#!/bin/bash


#export CLASSPATH=".:jar/*:$SCS_HOME/libs/*:$SCS_HOME/libs/jacorb/*:$SCS_HOME/libs/luaj/*"
#java -Djava.library.path=$SCS_HOME/libs \
#  -Djava.endorsed.dirs=$SCS_HOME/libs/jacorb -Djacorb.home=$SCS_HOME/libs/jacorb \
#  -Dorg.omg.CORBA.ORBClass=org.jacorb.orb.ORB \
#  -Dorg.omg.CORBA.ORBSingletonClass=org.jacorb.orb.ORBSingleton \
#  -cp $CLASSPATH "$@"

java -Djava.library.path=dist/*.jar:dist/lib/*.jar -Djava.endorsed.dirs=dist/lib -Djacorb.home=dist/lib -Dorg.omg.CORBA.ORBClass=org.jacorb.orb.ORB -Dorg.omg.CORBA.ORBSingletonClass=org.jacorb.orb.ORBSingleton -cp dist/scs-trab3.jar scstrab3.LogMonitorServer


