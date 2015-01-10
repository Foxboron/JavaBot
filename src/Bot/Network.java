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
    private String server = "irc.velox.pw";
    private int port = 6667;

    public void connect() throws IOException {
        String server;
        String port;
        Socket _socket = new Socket(this.server, this.port);
        this._writer = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream()));
        this._reader = new BufferedReader(new InputStreamReader(_socket.getInputStream()));

    }


    public void writer(String msg) throws IOException {
        // TODO: Iterate over list
        // The exceptions are real!
            this._writer.write(msg);

    }

    public BufferedReader reader() {
        return this._reader;
    }
}
