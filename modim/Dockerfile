FROM alpine:3.6

COPY modimage /opt/modi

# Set up env variables
ENV JAVA_HOME=/opt/modi
ENV PATH=$PATH:$JAVA_HOME/bin

ENTRYPOINT [ "modilula" ]
