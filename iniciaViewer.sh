#!/bin/bash

if [ $# -eq 0 ]; then
	echo $0 IOR1 IOR2 ...
	echo IORn é o IOR da faceta Source do LogMonitor
	exit 1;
fi;


java -Djava.library.path=dist/*.jar:dist/lib/*.jar -Djava.endorsed.dirs=dist/lib -Djacorb.home=dist/lib -Dorg.omg.CORBA.ORBClass=org.jacorb.orb.ORB -Dorg.omg.CORBA.ORBSingletonClass=org.jacorb.orb.ORBSingleton -cp dist/scs-trab3.jar scstrab3.LogViewerServer $*


