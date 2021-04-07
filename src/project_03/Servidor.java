package project_03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, EOFException {

		ServerSocket s = new ServerSocket(2001);

		while (true) {
			System.out.print("Esperando conexão.");
			Socket conexao = s.accept();
			System.out.println("Esperando mensagem.");

			DataInputStream entrada = new DataInputStream(conexao.getInputStream());
			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

			String linha = entrada.readUTF();

			while (linha != null && !(linha.trim().equals(""))) {
				saida.writeUTF("echo servidor: " + linha);
				linha = entrada.readUTF();
			}

			saida.writeUTF(linha);
			conexao.close();
		}
	}
}