require 'socket'
host = 'localhost'
port = 6666
server = TCPServer.open(host,port)                     
puts "Server has been successfully connected to #{port}"

loop {
    Thread.start(server.accept) do |client|  
        print "Waiting for client's message... "      

        client_msg = client.gets              
        puts "\nCliente: " + client_msg
        print "You: "   

        loop do          
            send = gets.chomp
            client.puts "Server: " + send
            client_msg = "Client: " + client.gets         
            puts   client_msg
            print "You: "            
            
        end      
      
    end
}