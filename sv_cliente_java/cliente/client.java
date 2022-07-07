import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.PrintWriter;

public class client
{
	public static void main(String[] args)
	{
		Socket socket = null;
		DataInputStream din = null;
		DataOutputStream dout = null;
		BufferedReader br = null;
        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc=new Scanner(System.in);

		try
		{
			socket = new Socket("localhost", 6666);
			out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader (new InputStreamReader(socket.getInputStream()));

            Thread sender= new Thread(new Runnable() {
                String msg;
                @Override  
                public void run() {
                    while(true){

                        Format hora = new SimpleDateFormat("HH.mm");
                        String horaStr = hora.format(new Date());

                        msg = sc.nextLine();
                        out.println("Client: " +msg );  
                        out.flush();  
					}
				}
			});
			sender.start();

        	try {
					String msg ;
                	 msg = in.readLine();
                        
                        while(msg!=null){
                            System.out.println(msg);
                            msg = in.readLine();
                        }  
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                

        } catch (IOException e) {
            e.printStackTrace();
        }

		catch (Exception exe)
		{
			exe.printStackTrace();
		}
		finally
		{
			try
			{

				if (br != null)
				{
					br.close();
				}

				if (din != null)
				{
					din.close();
				}

				if (dout != null)
				{
					dout.close();
				}
				if (socket != null)
				{
					socket.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	}
