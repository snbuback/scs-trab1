/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log_monitor.servant;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import log_monitor.FileModificationEvent;
import log_monitor.MonitorConfigurationPOA;

/**
 *
 * @author snbuback
 */
public class MonitorConfigurationServant extends MonitorConfigurationPOA {

    private final Thread threadMonitor;
    
    private final List<FileMonitoring> filesToMonitoring = new ArrayList<FileMonitoring>();
    
    private final String host;
    
    private final String ip;

    private long interval = 10000; // intervalo inicial de 10s

    private MonitorConfigurationServant() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        this.host = inetAddress.getHostName();
        this.ip = inetAddress.getHostAddress();

        // Cria a thread que vai ficar monitorando
        System.out.println("Cria thread que irá monitorar os eventos");
        this.threadMonitor = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(MonitorConfigurationServant.this.getInterval());
                    MonitorConfigurationServant.this.verifyModifications();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.threadMonitor.start();
    }

    @Override
    public void addFile(String arquivo) {
        File file = new File(arquivo);
        System.out.println("Adicionando arquivo " + file.getAbsolutePath() + " a lista de monitoramento");
        filesToMonitoring.add(new FileMonitoring(file));
    }

    @Override
    public String[] getMonitoringFiles() {
        String[] lista = new String[filesToMonitoring.size()];
        for (int i=0; i<lista.length; i++) {
            lista[i] = filesToMonitoring.get(i).getFile().getAbsolutePath();
        }
        System.out.println("Retornado " + lista.length + " arquivos: " + Arrays.toString(lista));
        return lista;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    void verifyModifications() {
        System.out.println("Verificando modificações de arquivos em " + new Date());
        for (FileMonitoring fileMonitoring : this.filesToMonitoring) {
            if (fileMonitoring.isModified()) {
                generateFileModificationEvent(fileMonitoring);
            }
        }
    }

    void generateFileModificationEvent(FileMonitoring fileMonitoring) {
        FileModificationEvent fme = new FileModificationEvent(fileMonitoring.getFile().getAbsolutePath(), getHost(), this.ip, System.currentTimeMillis());
        // FIXME: Disparar o evento

        // atualiza hora do arquivo para não disparar novamente o evento
        fileMonitoring.updateLastModification();
    }

    @Override
    public long getInterval() {
        return this.interval;
    }

    @Override
    public void setInterval(long interval) {
        this.interval = interval;
    }


}
