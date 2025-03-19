docker cp demo_small.sql postgres:/tmp/demo_small.sql
docker exec -it postgres psql -U postgres -d demo -f /tmp/demo_small.sql