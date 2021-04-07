package project_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {

		ServerSocket s = new ServerSocket(2000);
		System.out.println("Esperando conexão.");
	
		Socket conexao = s.accept();
		System.out.println("Conexão aceita. Esperando mensagem.");
		DataInputStream entrada = new DataInputStream(conexao.getInputStream());
		DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

		for (int i = 0; i <= 25; i++) {
			int linha = entrada.readInt();
			System.out.println("Mensagem recebida: " + linha);
			saida.writeUTF("recebi seu dado: " + linha);
		}
	}

}
