import java.net.ServerSocket
import kotlin.concurrent.thread


fun main()
{
    val server = ServerSocket(5000)

    val client = server.accept()

    val clientOutStream = client.getOutputStream()
    val clientInStream = client.getInputStream()

    thread {
        while(true)
        {
            var nextByte = clientInStream.read()
            print(nextByte.toChar())
        }
    }

    thread {
        while(true)
        {
            var input = readLine()!!
            clientOutStream.write(input.toByteArray())
        }
    }
}