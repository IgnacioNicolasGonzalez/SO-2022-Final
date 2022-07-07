var net = require('net');
const readline = require('readline-sync')

const server = net.createServer()       
const port = 6666

server.on('connection',(socket)=>{              
    socket.on('data', data =>{
        console.log(""+ data)
        sendLine()
    })
    socket.on('close',()=>{
        console.log("Connection ended")          
    })
    socket.on('error', (err)=>{
        console.log(err.message)
    })
    function sendLine(){                                   
        var line = readline.question('You: ')  
        if (line == "0"){
            socket.end()
        }else{
            socket.write("Server: " + line + "\n")      
        }
    
    }

})



server.listen(port, ()=>{
    console.log("Successfull connection with port ", server.address().port)  
})