:: portainer for easy manage of docker containers
docker stop portainer
docker rm portainer
docker pull portainer/portainer-ce:latest
docker run  --restart unless-stopped  --name portainer -d --privileged -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock -v /opt/portainer:/data portainer/portainer-ce

