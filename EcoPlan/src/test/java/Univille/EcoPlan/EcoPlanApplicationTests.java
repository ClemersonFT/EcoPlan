package Univille.EcoPlan;
import Univille.EcoPlan.entity.Denuncia;
import Univille.EcoPlan.entity.Objeto;
import Univille.EcoPlan.entity.SolicitacaoColeta;
import Univille.EcoPlan.entity.Usuario;
import Univille.EcoPlan.repository.ObjetoRepository;
import Univille.EcoPlan.repository.UsuarioRepository;
import Univille.EcoPlan.service.DenunciaService;
import Univille.EcoPlan.service.ObjetoService;
import Univille.EcoPlan.service.SolicitacaoColetaService;
import Univille.EcoPlan.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcoPlanApplicationTests {

	@Test
	void contextLoads() {
	}

	@SpringBootApplication
	public class EcoPlanApplication {

		public static void main(String[] args) {
			SpringApplication.run(EcoPlanApplication.class, args);
		}

		@Bean
		CommandLineRunner testarSistema(
				UsuarioService usuarioService,
				DenunciaService denunciaService,
				SolicitacaoColetaService solicitacaoColetaService,
				ObjetoRepository objetoRepository
		) {
			return args -> {

				System.out.println("=== INICIANDO TESTE DO SISTEMA ===");

				// 1️⃣ Criar usuário
				Usuario usuario = new Usuario();
				usuario.setNome("Clemerson");
				usuario.setCpf("12345678900");
				usuario.setEmail("clemerson@email.com");
				usuario.setSenha("123456");
				usuario.setLocalizacao("Joinville");

				usuario = usuarioService.cadastrarUsuario(usuario);

				System.out.println("Usuário criado ID: " + usuario.getId());

				// 2️⃣ Criar objeto manualmente (não tem regra de negócio)
				Objeto objeto = new Objeto();
				objeto.setTipo("Geladeira");
				objeto.setMarca("Consul");
				objeto.setCategoria("Eletrodoméstico");
				objeto.setDescricao("Levar para ponto de descarte eletrônico.");

				objeto = objetoRepository.save(objeto);

				System.out.println("Objeto criado ID: " + objeto.getId());

				// 3️⃣ Criar denúncia
				Denuncia denuncia = new Denuncia();
				denuncia.setDescricao("Geladeira jogada em terreno baldio");
				denuncia.setLocalizacao("Rua X, Joinville");

				denunciaService.criarDenuncia(denuncia, usuario.getId());

				System.out.println("Denúncia criada.");

				// 4️⃣ Criar solicitação de coleta
				SolicitacaoColeta solicitacao = new SolicitacaoColeta();
				solicitacao.setLocalizacao("Rua X, Joinville");

				solicitacaoColetaService.criarSolicitacaoColeta(solicitacao, usuario.getId());

				System.out.println("Solicitação criada.");

				// 5️⃣ Listar denúncias do usuário
				System.out.println("Denúncias do usuário:");
				denunciaService.listarPorUsuario(usuario.getId())
						.forEach(d -> System.out.println(d.getDescricao()));

				// 6️⃣ Listar solicitações do usuário
				System.out.println("Solicitações do usuário:");
				solicitacaoColetaService.listarSolicitacoes(usuario.getId())
						.forEach(s -> System.out.println(s.getLocalizacao()));

				System.out.println("=== TESTE FINALIZADO ===");
			};
		}
	}
}
