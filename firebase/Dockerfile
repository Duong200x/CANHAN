FROM node:20-bookworm-slim

WORKDIR /workspace

RUN apt-get update \
 && apt-get install -y --no-install-recommends openjdk-17-jre-headless \
 && rm -rf /var/lib/apt/lists/*

RUN npm i -g firebase-tools@13.31.2

CMD ["firebase","emulators:start","--project","demo-canhan","--only","auth,firestore,ui","--import","/workspace/.firebase-data","--export-on-exit"]
