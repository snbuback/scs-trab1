#!/bin/bash

java -Djava.library.path=dist/*.jar:dist/lib/*.jar -Djava.endorsed.dirs=dist/lib -Djacorb.home=dist/lib -Dorg.omg.CORBA.ORBClass=org.jacorb.orb.ORB -Dorg.omg.CORBA.ORBSingletonClass=org.jacorb.orb.ORBSingleton -cp dist/scs-trab3.jar scstrab3.LogViewerServer $*


