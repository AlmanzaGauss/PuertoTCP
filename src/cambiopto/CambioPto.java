/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiopto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author falag
 */
public class CambioPto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                        try {
            // TODO code application logic here
            System.out.println("Servidor");
            DatagramSocket miSocket= new DatagramSocket(5010);
            byte[] buffer = new byte[1824];
            while(true)
            {
                DatagramPacket peticion= new DatagramPacket(buffer, buffer.length);
              miSocket.receive(peticion);
              HilosServer hilo= new HilosServer(miSocket, peticion);
              hilo.start();
            }
        } catch (SocketException ex) {
            Logger.getLogger(CambioPto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CambioPto.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO code application logic here
    }
}
