FROM alpine:3.6

# copy the Java runtime image to the /opt/modi directory of the container
COPY image /opt/modi

# Set up env variables
ENV JAVA_HOME=/opt/modi
ENV PATH=$PATH:$JAVA_HOME/bin

ENTRYPOINT [ "transitive" ]
