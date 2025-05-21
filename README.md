// 21 May 2025 created repository
mvn archetype:generate -DgroupId=com.manipradeep.learning -DartifactId=learnings -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

//For child module 

mvn archetype:generate -DgroupId=com.companyname.blogger -DartifactId=blogger-core -DinteractiveMode=false


//For webapp

mvn archetype:generate -DgroupId=com.companyname.blogger -DartifactId=blogger-web -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

mvn clean install -DskipTests
