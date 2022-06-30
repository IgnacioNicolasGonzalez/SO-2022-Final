var net = require('net');

var host = '0.0.0.0';
var port = 2000;

net.createServer(sock => {

    console.log(`connected: ${sock.remoteAddress}:${sock.remotePort}`);

    sock.on('data', (data) => {
        console.log(`${sock.remoteAddress}: ${data}`);
        sock.write(`${data}`);
    });

    sock.on('close', (data) => {
        console.log(`connection closed: ${sock.remoteAddress}:${sock.remotePort}`);
    });

}).listen(port, host);

console.log(`Server listening on ${host}:${port}`);