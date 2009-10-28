/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log_monitor.servant;

import java.io.File;

/**
 *
 * @author snbuback
 */
public class FileMonitoring {

    private final File file;

    private long lastModification;

    public FileMonitoring(File file) {
        this.file = file;
        updateLastModification();
    }

    public File getFile() {
        return this.file;
    }

    public boolean isModified() {
        return lastModification != getFile().lastModified();
    }

    void updateLastModification() {
        this.lastModification = getFile().lastModified();
    }

}
