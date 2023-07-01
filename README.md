# mac-boot-mongodb

### Setup Mongodb
```
docker run --name mac-mongo -p 27017:27017 --env=MONGO_INITDB_ROOT_USERNAME=root --env=MONGO_INITDB_ROOT_PASSWORD=password -d mongo:latest
```
