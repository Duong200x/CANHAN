const express = require("express");
const app = express();

app.get("/health", (_, res) => res.json({ ok: true, runtime: "node" }));
app.listen(3000, () => console.log("node app on :3000"));
