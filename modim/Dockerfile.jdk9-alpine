# A JDK 9 with Alpine Linux
FROM alpine:3.6
# Add the musl-based JDK 9 distribution
RUN mkdir /opt

ADD jdk-9-ea+181_linux-x64-musl_bin.tar.gz /opt
# Set up env variables
ENV JAVA_HOME=/opt/jdk-9
ENV PATH=$PATH:$JAVA_HOME/bin

CMD ["jshell", "-J-XX:+UnlockExperimentalVMOptions", \
               "-J-XX:+UseCGroupMemoryLimitForHeap", \
               "-R-XX:+UnlockExperimentalVMOptions", \
               "-R-XX:+UseCGroupMemoryLimitForHeap"]

