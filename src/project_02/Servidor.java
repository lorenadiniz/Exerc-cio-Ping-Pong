package project_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {

		InetAddress endereco_remoto;
		int porta_remota;
		ServerSocket s = new ServerSocket(2000);
		System.out.println("Esperando conex?o");

		Socket conexao = s.accept();
		DataInputStream entrada = new DataInputStream(conexao.getInputStream());
		DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

		System.out.println("Esperando mensagem.");
		endereco_remoto = conexao.getInetAddress();
		porta_remota = conexao.getPort();

		System.out.println("Nome da maquina remota: " + endereco_remoto.getHostName());
		System.out.println("IP da maquina remota: " + endereco_remoto.getHostAddress());
		System.out.println("Porta maquina remota: " + porta_remota);

		for (int i = 0; i <= 25; i++) {
			int linha = entrada.readInt();
			System.out.println("Mensagem recebida: " + linha);
			saida.writeUTF("Mensagem recebida: " + linha);
		}
	}
}
