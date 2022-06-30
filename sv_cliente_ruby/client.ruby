require 'socket'
hostname = 'localhost' 
port = 6666            
connection= TCPSocket.open(hostname, port) 
print "You: "

loop do                 
    msg = gets.chomp
    connection.puts msg
    sv_msg = connection.gets          
    puts  sv_msg                   
    print "You: "
end


