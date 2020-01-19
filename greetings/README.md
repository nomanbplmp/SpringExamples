## Springboot Java Maven Jib


Sample project to create Docker image using Jib plugin and loading image to dockerhub
Jib is an open-source Java tool maintained by Google for building Docker images of java applications. Jib is alternate to create Docker image without DockerFile and even without docker.

 https://cloud.google.com/blog/products/gcp/introducing-jib-build-java-docker-images-better

Configure pluin in pom.xml. inside image tag  mentioned the repository to upload the created image.

```
<plugin>
                <groupId>com.google.cloud.tools</groupId>
                <artifactId>jib-maven-plugin</artifactId>
                <version>1.7.0</version>
                <configuration>

                    <to>
                        <image>registry.hub.docker.com/khannomanahmed1/greetings</image>
                        <tags>
                            <tag>latest</tag>
                        </tags>
                    </to>
                </configuration>
                <executions>
                    <execution>
                        <phase>
                            install
                        </phase>
                        <goals>
                            <goal>build</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

 ```           
            
  Edit  maven settings.xml 
  
  Add  
   ```xml
   <servers>
         <server>
             <id>registry.hub.docker.com</id>
             <username>username</username>
             <password>password</password>
         </server>
     </servers>
  ```
  
 Run ->
       mvn install 
 
