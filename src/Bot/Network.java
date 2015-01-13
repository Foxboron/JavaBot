package Bot;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

/**
 * Created by fox on 1/10/15.
 */
public class Network {


    private Socket _sock = null;
    private BufferedWriter _writer = null;
    private BufferedReader _reader = null;

    public void connect(String server, int port) throws IOException {
        Socket _socket = new Socket(server, port);
        this._writer = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream()));
        this._reader = new BufferedReader(new InputStreamReader(_socket.getInputStream()));

    }


    public void writer(String msg) throws IOException {
        // TODO: Iterate over list
        // The exceptions are real!
        if(!msg.isEmpty()) {
            this._writer.write(msg);
            this._writer.newLine(); //HERE!!!!!!
            this._writer.flush();
        }
    }

    public String readLine() throws IOException {
        return this._reader.readLine();
    }
}
