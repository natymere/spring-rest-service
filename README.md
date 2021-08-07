# Simple REST services with Spring
This is a tutorial from spring.io. 

## Dockerfile
1. Pull the image from docker repository
2. Copy jar file into the image
3. exec form of the Dockerfile ENTRYPOINT is used so that there is no shell wrapping the java process. The advantage 
is that the JAVA process respond to the KILL signal sent to the container.
4. Refer to Dockerfile.

## Docker command
To build an image:

`docker build -t myorg/myapp .`

To run the docker

`docker run --name myapp -it --enrtrypoint myorg/myapp`

To interact with the docker

`docker exec -it myapp /bash`

## Summary
- REST is not about just pretty URIs and return JSON instead of XML.
- Don't remove old fields. instead, support them.
- rel-based (HATEAOS) - did not implement
- Retain old links as long as possible
- use links, not payload data, to instruct clients when various state-driving operation are available
