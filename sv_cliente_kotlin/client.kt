import java.net.Socket
import kotlin.concurrent.thread

fun main()
{
    val client = Socket("localhost", 5000)

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