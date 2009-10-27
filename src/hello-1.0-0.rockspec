package = "Hello"
version = "1.0-0"
language = "java"
description = {
	summary = "Java version of the Hello component",
	detailed = "Awesome!",
	license = "MIT",
	homepage = "http://www.tecgraf.puc-rio.br/~amadeu",
	maintainer = "Amadeu A. B. Jr",
}
dependencies = { }
source = {
   url = "file://Hello.zip",
   dir = "src/java/scs/demos/helloworld",
}
build = {
	type = "command",
	build_command = "ant",
	install = {
		java = { "jar/helloworld.jar", },
		conf = { "conf/hello.template", "conf/hello.java.all.desc" },
	},
	copy_directories = { "idl" },
}
