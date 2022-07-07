var net = require('net');
const readline = require('readline-sync')
const options = {
    port : 6666,
    host: 'localhost'
}
const client = net.createConnection(options)

function sendLine(){
    var line = readline.question('You: ')   
    if (line == "0"){
        client.end()
    }else{
        client.write("Client: " + line +"\n") 
    }
}

client.on('connect',()=>{                   
    console.log('Successfull connection with Server')
    sendLine()
})

client.on('error',(err)=>{
    console.log(err.message)
})
client.on('data',(data)=>{
    console.log(''+ data)
    sendLine()
})

