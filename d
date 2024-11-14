[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ClienteController.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ClienteController.java[m
[1mnew file mode 100644[m
[1mindex 0000000..4f2d7bc[m
[1m--- /dev/null[m
[1m+++ b/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ClienteController.java[m
[36m@@ -0,0 +1,106 @@[m
[32m+[m[32mpackage com.ghastconsultancy.ghastconsultancy.controller;[m
[32m+[m
[32m+[m[32mimport com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;[m
[32m+[m[32mimport com.ghastconsultancy.ghastconsultancy.model.Cliente;[m
[32m+[m[32mimport com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;[m
[32m+[m[32mimport org.springframework.http.HttpStatus;[m
[32m+[m[32mimport org.springframework.http.ResponseEntity;[m
[32m+[m[32mimport org.springframework.web.bind.annotation.*;[m
[32m+[m
[32m+[m[32mimport java.util.List;[m
[32m+[m[32mimport java.util.Optional;[m
[32m+[m
[32m+[m[32m@RestController[m
[32m+[m[32m@RequestMapping("/clientes")[m
[32m+[m[32mpublic class ClienteController {[m
[32m+[m
[32m+[m[32m    private ClienteRepository clienteRepository;[m
[32m+[m
[32m+[m[32m    // Injeção de dependência via construtor[m
[32m+[m[32m    public ClienteController(ClienteRepository clienteRepository) {[m
[32m+[m[32m        this.clienteRepository = clienteRepository;[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    // Métodos omitidos:[m
[32m+[m[32m    // Method de criação de cliente[m
[32m+[m[32m    @PostMapping[m
[32m+[m[32m    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {[m
[32m+[m[32m        cliente.setTipoCliente(TipoCliente.PADRAO);[m
[32m+[m[32m        Cliente novoCliente = clienteRepository.save(cliente);[m
[32m+[m[32m        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    // Method de atualização de cliente[m
[32m+[m[32m    @PutMapping("/{id}")[m
[32m+[m[32m    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {[m
[32m+[m[32m        Optional<Cliente> clienteExistente = clienteRepository.findById(id);[m
[32m+[m
[32m+[m[32m        if (clienteExistente.isPresent()) {[m
[32m+[m[32m            Cliente clienteAtualizado = clienteExistente.get();[m
[32m+[m[32m            clienteAtualizado.setNome(cliente.getNome());[m
[32m+[m[32m            clienteAtualizado.setCpf(cliente.getCpf());[m
[32m+[m[32m            clienteAtualizado.setEmail(cliente.getEmail());[m
[32m+[m[32m            clienteAtualizado.setTelefone(cliente.getTelefone());[m
[32m+[m[32m            clienteRepository.save(clienteAtualizado);[m
[32m+[m[32m            return ResponseEntity.ok(clienteAtualizado);[m
[32m+[m[32m        } else {[m
[32m+[m[32m            return ResponseEntity.notFound().build();[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    // Method de exclusão de cliente[m
[32m+[m[32m    @DeleteMapping("/{id}")[m
[32m+[m[32m    public ResponseEntity<Void> excluirClientePorId(@PathVariable Long id) {[m
[32m+[m[32m        // Verifica se o cliente existe[m
[32m+[m[32m        if (!clienteRepository.existsById(id)) {[m
[32m+[m[32m            // Retorna uma resposta de não encontrado[m
[32m+[m[32m            return ResponseEntity.notFound().build();[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        // Exclui o cliente[m
[32m+[m[32m        clienteRepository.deleteById(id);[m
[32m+[m[32m        return ResponseEntity.noContent().build(); // Retorna uma resposta 201 sem conteúdo[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    // Method de busca de cliente por ID[m
[32m+[m[32m    @GetMapping("/{id}")[m
[32m+[m[32m    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {[m
[32m+[m[32m        Optional<Cliente> cliente = clienteRepository.findById(id);[m
[32m+[m
[32m+[m[32m        // Retorna o cliente encontrado ou uma resposta de não encontrado[m
[32m+[m[32m        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    // Method de listar de todos os clientes[m
[32m+[m[32m    @GetMapping[m
[32m+[m[32m    public List<Cliente> listarTodosClientes() {[m
[32m+[m[32m        // Retorna todos os clientes cadastrados[m
[32m+[m[32m        return clienteRepository.findAll();[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    // Method de promoção de cliente para VIP[m
[32m+[m[32m    @PutMapping("/{id}/promover")[m
[32m+[m[32m    public ResponseEntity<Cliente> promoverClienteParaVip(@PathVariable Long id) {[m
[32m+[m[32m        Optional<Cliente> clienteExistente = clienteRepository.findById(id);[m
[32m+[m
[32m+[m[32m        if (clienteExistente.isPresent()) {[m
[32m+[m[32m            Cliente cliente = clienteExistente.get();[m
[32m+[m[32m            cliente.promoverParaVip();[m
[32m+[m[32m            clienteRepository.save(cliente);[m
[32m+[m[32m            return ResponseEntity.ok(cliente);[m
[32m+[m[32m        } else {[m
[32m+[m[32m            return ResponseEntity.notFound().build();[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    // Method de busca de clientes VIP[m
[32m+[m[32m    @GetMapping("/vip")[m
[32m+[m[32m    public ResponseEntity<List<Cliente>> buscarClientesVip() {[m
[32m+[m[32m        List<Cliente> clientesVip = clienteRepository.findByTipoCliente(TipoCliente.VIP);[m
[32m+[m[32m        if (clientesVip.isEmpty()) {[m
[32m+[m[32m            return ResponseEntity.noContent().build();[m
[32m+[m[32m        }[m
[32m+[m[32m        return ResponseEntity.ok(clientesVip);[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ConsultorController.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ConsultorController.java[m
[1mindex 591cbf9..857d731 100644[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ConsultorController.java[m
[1m+++ b/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ConsultorController.java[m
[36m@@ -11,20 +11,21 @@[m [mimport java.util.List;[m
 import java.util.Optional;[m
 [m
 @RestController[m
[31m-@RequestMapping("/consultor")[m
[32m+[m[32m@RequestMapping("/consultores")[m
 [m
 @AllArgsConstructor[m
 public class ConsultorController {[m
 [m
     private ConsultorRepository consultorRepository;[m
 [m
[31m-    @PostMapping("/cadastrar") // @ResquestBody  -> Anotação para converter o Json em um objeto to tipo Consultor[m
[32m+[m[32m    @PostMapping("/cadastrar") // @ResquestBody -> Anotação para converter o Json em um objeto to tipo Consultor[m
     public ResponseEntity<String> cadastrarConsultor(@RequestBody Consultor consultor) {[m
 [m
         if(consultorRepository.findByCpf(consultor.getCpf()).isPresent()) {[m
                 return ResponseEntity.status(HttpStatus.CONFLICT).body("Consultor já cadastrado");[m
                 // HttpStatus.CONFLICT ->, 409, ou seja, o recurso já existe[m
         }[m
[32m+[m[32m        consultorRepository.save(consultor);[m
         return ResponseEntity.status(HttpStatus.CREATED).body("Consultor cadastrado com sucesso");[m
         // HttpStatus.CREATED -> 201, ou seja, o recurso foi criado[m
     }[m
[36m@@ -43,16 +44,9 @@[m [mpublic class ConsultorController {[m
     @GetMapping("/consultar/{id}")[m
     public ResponseEntity<Consultor> consultarPorId(@PathVariable Long id) {[m
         Optional<Consultor> consultor = consultorRepository.findById(id);[m
[31m-        if (consultor.isEmpty()) {[m
[31m-            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();[m
[31m-            // Erro 404 o usuário nao foi encontrado[m
[31m-        }[m
[31m-        else{[m
[31m-            return ResponseEntity.ok(consultor.get());[m
[31m-            // ok -> 200 deu tudo certo[m
[31m-        }[m
[31m-[m
[31m-[m
[32m+[m[32m        // Erro 404 o usuário nao foi encontrado[m
[32m+[m[32m        // ok -> 200 deu tudo certo[m
[32m+[m[32m        return consultor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());[m
     }[m
 [m
     @PutMapping("/editar/{id}")[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/EtapaController.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/EtapaController.java[m
[1mdeleted file mode 100644[m
[1mindex 30d18b4..0000000[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/EtapaController.java[m
[1m+++ /dev/null[m
[36m@@ -1,71 +0,0 @@[m
[31m-package com.ghastconsultancy.ghastconsultancy.controller;[m
[31m-[m
[31m-import com.ghastconsultancy.ghastconsultancy.enums.StatusEtapa;[m
[31m-import com.ghastconsultancy.ghastconsultancy.model.Etapa;[m
[31m-import com.ghastconsultancy.ghastconsultancy.repository.EtapaRepository;[m
[31m-import org.springframework.http.HttpStatus;[m
[31m-import org.springframework.http.ResponseEntity;[m
[31m-import org.springframework.web.bind.annotation.*;[m
[31m-[m
[31m-import java.util.List;[m
[31m-import java.util.Optional;[m
[31m-[m
[31m-@RestController[m
[31m-@RequestMapping(("/etapas"))[m
[31m-public class EtapaController {[m
[31m-[m
[31m-    private final EtapaRepository etapaRepository;[m
[31m-[m
[31m-    public EtapaController(EtapaRepository etapaRepository) {[m
[31m-        this.etapaRepository = etapaRepository;[m
[31m-    }[m
[31m-[m
[31m-    @GetMapping[m
[31m-    public ResponseEntity<List<Etapa>> cosultarTodos(){[m
[31m-        List<Etapa> etapas = etapaRepository.findAll();[m
[31m-        return ResponseEntity.status(HttpStatus.OK).body(etapas);[m
[31m-    }[m
[31m-[m
[31m-    @GetMapping("/{id}")[m
[31m-    public ResponseEntity<Etapa> consultar(@PathVariable Long id){[m
[31m-        Optional<Etapa> etapa = etapaRepository.findById(id);[m
[31m-        return etapa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());[m
[31m-    }[m
[31m-[m
[31m-    @GetMapping("/status/{statusEtapa}")[m
[31m-    public ResponseEntity<List<Etapa>> consultarStatus(@PathVariable StatusEtapa statusEtapa){[m
[31m-        List<Etapa> etapas = etapaRepository.findByStatusEtapa(statusEtapa);[m
[31m-        return ResponseEntity.ok(etapas);[m
[31m-    }[m
[31m-[m
[31m-[m
[31m-    @PutMapping("/{id}")[m
[31m-    public ResponseEntity<Etapa> editarEtapa(@PathVariable Long id, @RequestBody Etapa etapaParam){[m
[31m-        Optional<Etapa> etapaOptional = etapaRepository.findById(id);[m
[31m-[m
[31m-        if(etapaOptional.isPresent()){[m
[31m-            Etapa etapa = etapaOptional.get();[m
[31m-[m
[31m-            etapa.setNome(etapaParam.getNome());[m
[31m-            etapa.setDescricao(etapaParam.getDescricao());[m
[31m-            etapa.setStatusEtapa(etapaParam.getStatusEtapa());[m
[31m-            etapaRepository.save(etapa);[m
[31m-[m
[31m-            return ResponseEntity.status(HttpStatus.OK).body(etapa);[m
[31m-        }[m
[31m-        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();[m
[31m-[m
[31m-    }[m
[31m-[m
[31m-    @DeleteMapping("/{id}")[m
[31m-    public ResponseEntity<Etapa> deleterEtapa(@PathVariable Long id){[m
[31m-        Optional<Etapa> etapa =etapaRepository.findById(id);[m
[31m-        if(etapa.isEmpty()){[m
[31m-            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();[m
[31m-        }[m
[31m-        else{[m
[31m-            etapaRepository.deleteById(id);[m
[31m-            return ResponseEntity.status(HttpStatus.OK).body(etapa.get());[m
[31m-        }[m
[31m-    }[m
[31m-}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ProjetoController.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ProjetoController.java[m
[1mdeleted file mode 100644[m
[1mindex 5354cb9..0000000[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/controller/ProjetoController.java[m
[1m+++ /dev/null[m
[36m@@ -1,108 +0,0 @@[m
[31m-package com.ghastconsultancy.ghastconsultancy.controller;[m
[31m-[m
[31m-import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;[m
[31m-import com.ghastconsultancy.ghastconsultancy.model.Etapa;[m
[31m-import com.ghastconsultancy.ghastconsultancy.model.Projeto;[m
[31m-import com.ghastconsultancy.ghastconsultancy.repository.ProjetoRepository;[m
[31m-[m
[31m-import org.springframework.http.HttpStatus;[m
[31m-import org.springframework.http.ResponseEntity;[m
[31m-import org.springframework.web.bind.annotation.*;[m
[31m-[m
[31m-import java.util.List;[m
[31m-import java.util.Optional;[m
[31m-[m
[31m-[m
[31m-@RestController[m
[31m-@RequestMapping("/projetos")[m
[31m-public class ProjetoController {[m
[31m-[m
[31m-    private final ProjetoRepository projetoRepository;[m
[31m-[m
[31m-    public ProjetoController(ProjetoRepository projetoRepository) {[m
[31m-        this.projetoRepository = projetoRepository;[m
[31m-    }[m
[31m-[m
[31m-    @PostMapping[m
[31m-    public ResponseEntity<Projeto> CriarProjeto(@RequestBody Projeto projeto){[m
[31m-        projetoRepository.save(projeto);[m
[31m-        return ResponseEntity.status(HttpStatus.CREATED).body(projeto);[m
[31m-    }[m
[31m-[m
[31m-    @GetMapping[m
[31m-    public ResponseEntity<List<Projeto>> ListarProjetos(){[m
[31m-        return ResponseEntity.status(HttpStatus.OK).body(projetoRepository.findAll());[m
[31m-    }[m
[31m-[m
[31m-    @GetMapping("/{id}")[m
[31m-    public ResponseEntity<Projeto> ListarProjetoPorId(@PathVariable Long id){[m
[31m-        Optional<Projeto> projeto = projetoRepository.findById(id);[m
[31m-        return  projeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());[m
[31m-    }[m
[31m-[m
[31m-    @GetMapping("/status/{statusProjeto}")[m
[31m-    public ResponseEntity<List<Projeto>> ListarProjetoPorStatus(@PathVariable StatusProjeto statusProjeto){[m
[31m-        List<Projeto> projetos = projetoRepository.findByStatusProjeto(statusProjeto);[m
[31m-        return ResponseEntity.status(HttpStatus.OK).body(projetos);[m
[31m-    }[m
[31m-[m
[31m-    @PutMapping("/{id}")[m
[31m-    public ResponseEntity<Projeto> AtualizarProjeto(@PathVariable Long id,@RequestBody Projeto projetoParam){[m
[31m-        Optional<Projeto> projeto = projetoRepository.findById(id);[m
[31m-        if(projeto.isPresent()){[m
[31m-            projeto.get().setNome(projetoParam.getNome());[m
[31m-            projeto.get().setDescricao(projetoParam.getDescricao());[m
[31m-            projetoRepository.save(projeto.get());[m
[31m-            return ResponseEntity.status(HttpStatus.OK).body(projeto.get());[m
[31m-        }[m
[31m-        else{[m
[31m-            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);[m
[31m-        }[m
[31m-    }[m
[31m-[m
[31m-    @PutMapping("/{id}/etapas")[m
[31m-    public ResponseEntity<Projeto> AdicionarEtapa(@PathVariable Long id, @RequestBody Etapa etapa){[m
[31m-[m
[31m-        Optional<Projeto> projeto = projetoRepository.findById(id);[m
[31m-        if(projeto.isPresent()){[m
[31m-            projeto.get().addEtapas(etapa);[m
[31m-            etapa.setProjeto(projeto.get());[m
[31m-            projetoRepository.save(projeto.get());[m
[31m-            return ResponseEntity.status(HttpStatus.OK).body(projeto.get());[m
[31m-        }[m
[31m-        else{[m
[31m-            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);[m
[31m-        }[m
[31m-    }[m
[31m-[m
[31m-    @PutMapping("/{id}/etapas/{etapasId}")[m
[31m-    public ResponseEntity<Projeto> DeletarEtapa(@PathVariable Long id,@PathVariable Long etapasId){[m
[31m-        Optional<Projeto> projetoOptional = projetoRepository.findById(id);[m
[31m-        if(projetoOptional.isPresent()){[m
[31m-[m
[31m-            Projeto projeto = projetoOptional.get();[m
[31m-[m
[31m-            for (Etapa etapa : projeto.getEtapas()){[m
[31m-                if(etapa.getId().equals(etapasId)){[m
[31m-                    projeto.removerEtapas(etapa);[m
[31m-                    projetoRepository.save(projeto);[m
[31m-                    return ResponseEntity.status(HttpStatus.OK).body(projeto);[m
[31m-                }[m
[31m-            }[m
[31m-            // se não encontrar Nenhuma etapa com esse id[m
[31m-            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);[m
[31m-        }[m
[31m-        //se não encontrar nenhum Projeto com esse id[m
[31m-        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);[m
[31m-    }[m
[31m-[m
[31m-    @DeleteMapping("/{id}")[m
[31m-    public ResponseEntity<Projeto> DeletarProjeto(@PathVariable Long id){[m
[31m-        Optional<Projeto> projeto = projetoRepository.findById(id);[m
[31m-        if(projeto.isPresent()){[m
[31m-            projetoRepository.delete(projeto.get());[m
[31m-            return ResponseEntity.status(HttpStatus.OK).body(projeto.get());[m
[31m-        }[m
[31m-        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();[m
[31m-    }[m
[31m-}[m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/Especializacao.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/Especializacao.java[m
[1mindex d044069..8316433 100644[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/Especializacao.java[m
[1m+++ b/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/Especializacao.java[m
[36m@@ -21,7 +21,7 @@[m [mpublic enum Especializacao {[m
                 return value;[m
             }[m
         }[m
[31m-        throw new IllegalArgumentException("Código para a especialização inválido");[m
[32m+[m[32m        throw new IllegalArgumentException("Código para o tipo de atendimento inválido");[m
     }[m
 [m
 [m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/StatusEtapa.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/StatusEtapa.java[m
[1mdeleted file mode 100644[m
[1mindex d08cfb3..0000000[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/StatusEtapa.java[m
[1m+++ /dev/null[m
[36m@@ -1,6 +0,0 @@[m
[31m-package com.ghastconsultancy.ghastconsultancy.enums;[m
[31m-[m
[31m-public enum StatusEtapa {[m
[31m-    EM_ANDAMENTO,[m
[31m-    CONCLUIDO;[m
[31m-}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/StatusProjeto.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/StatusProjeto.java[m
[1mdeleted file mode 100644[m
[1mindex 4916e7e..0000000[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/StatusProjeto.java[m
[1m+++ /dev/null[m
[36m@@ -1,7 +0,0 @@[m
[31m-package com.ghastconsultancy.ghastconsultancy.enums;[m
[31m-[m
[31m-public enum StatusProjeto {[m
[31m-    EM_ESPERA,[m
[31m-    EM_CURSO,[m
[31m-    FINALIZADO;[m
[31m-}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/TipoCliente.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/TipoCliente.java[m
[1mnew file mode 100644[m
[1mindex 0000000..b13d298[m
[1m--- /dev/null[m
[1m+++ b/src/main/java/com/ghastconsultancy/ghastconsultancy/enums/TipoCliente.java[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32mpackage com.ghastconsultancy.ghastconsultancy.enums;[m
[32m+[m
[32m+[m[32mpublic enum TipoCliente {[m
[32m+[m[32m    PADRAO,[m
[32m+[m[32m    VIP[m
[32m+[m[32m}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Cliente.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Cliente.java[m
[1mnew file mode 100644[m
[1mindex 0000000..b1bec1e[m
[1m--- /dev/null[m
[1m+++ b/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Cliente.java[m
[36m@@ -0,0 +1,48 @@[m
[32m+[m[32mpackage com.ghastconsultancy.ghastconsultancy.model;[m
[32m+[m
[32m+[m[32mimport com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;[m
[32m+[m[32mimport jakarta.persistence.*;[m
[32m+[m[32mimport lombok.Getter;[m
[32m+[m[32mimport lombok.NoArgsConstructor;[m
[32m+[m[32mimport lombok.Setter;[m
[32m+[m
[32m+[m[32m@Getter[m
[32m+[m[32m@Setter[m
[32m+[m[32m@Entity[m
[32m+[m[32m@NoArgsConstructor[m
[32m+[m[32m@Table(name = "clientes")[m
[32m+[m[32mpublic class Cliente {[m
[32m+[m
[32m+[m[32m    @Id[m
[32m+[m[32m    @GeneratedValue(strategy = GenerationType.IDENTITY)[m
[32m+[m[32m    private Long id;[m
[32m+[m
[32m+[m[32m    @Column(name = "nome", length = 50, nullable = false)[m
[32m+[m[32m    private String nome;[m
[32m+[m
[32m+[m[32m    @Column(name = "cpf", length = 30, nullable = false, unique = true)[m
[32m+[m[32m    private String cpf;[m
[32m+[m
[32m+[m[32m    @Column(name = "email", length = 50, nullable = false)[m
[32m+[m[32m    private String email;[m
[32m+[m
[32m+[m[32m    @Column(name = "telefone", length = 15)[m
[32m+[m[32m    private String telefone;[m
[32m+[m
[32m+[m[32m    @Enumerated(EnumType.STRING)[m
[32m+[m[32m    @Column(name = "tipo_cliente", nullable = false)[m
[32m+[m[32m    private TipoCliente tipoCliente = TipoCliente.PADRAO;[m
[32m+[m
[32m+[m[32m    public Cliente(String nome, String cpf, String email, String telefone) {[m
[32m+[m[32m        this.nome = nome;[m
[32m+[m[32m        this.cpf = cpf;[m
[32m+[m[32m        this.email = email;[m
[32m+[m[32m        this.telefone = telefone;[m
[32m+[m[32m        this.tipoCliente = TipoCliente.PADRAO; // Define o tipo padrão ao criar o cliente[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    // Method para atualizar o tipo de cliente para VIP[m
[32m+[m[32m    public void promoverParaVip() {[m
[32m+[m[32m        this.tipoCliente = TipoCliente.VIP;[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Etapa.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Etapa.java[m
[1mdeleted file mode 100644[m
[1mindex 39f036a..0000000[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Etapa.java[m
[1m+++ /dev/null[m
[36m@@ -1,44 +0,0 @@[m
[31m-package com.ghastconsultancy.ghastconsultancy.model;[m
[31m-[m
[31m-[m
[31m-import com.fasterxml.jackson.annotation.JsonIgnore;[m
[31m-import com.ghastconsultancy.ghastconsultancy.enums.StatusEtapa;[m
[31m-import jakarta.persistence.*;[m
[31m-import lombok.*;[m
[31m-[m
[31m-[m
[31m-@Setter[m
[31m-@Getter[m
[31m-@Entity[m
[31m-@NoArgsConstructor[m
[31m-@Table(name="etapas")[m
[31m-public class Etapa {[m
[31m-[m
[31m-[m
[31m-    @Id[m
[31m-    @GeneratedValue(strategy = GenerationType.IDENTITY)[m
[31m-    @Column(name="id")[m
[31m-    private Long id;[m
[31m-[m
[31m-    @Column(name="nome",length = 20,nullable = false)[m
[31m-    private String nome;[m
[31m-[m
[31m-    @Column(name="descricao",length = 100)[m
[31m-    private String descricao;[m
[31m-    [m
[31m-    @Enumerated(EnumType.STRING)[m
[31m-    @Column(name= "status",nullable = false)[m
[31m-    private StatusEtapa statusEtapa = StatusEtapa.EM_ANDAMENTO;[m
[31m-[m
[31m-    @JsonIgnore[m
[31m-    @JoinColumn(name= "projeto",nullable = false)[m
[31m-    @ManyToOne(fetch = FetchType.LAZY)[m
[31m-    private Projeto projeto;[m
[31m-[m
[31m-    public Etapa(String nome, String descricao, Projeto projeto) {[m
[31m-        this.nome = nome;[m
[31m-        this.descricao = descricao;[m
[31m-        this.projeto = projeto;[m
[31m-    }[m
[31m-[m
[31m-}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Projeto.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Projeto.java[m
[1mdeleted file mode 100644[m
[1mindex 7eefd7f..0000000[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/model/Projeto.java[m
[1m+++ /dev/null[m
[36m@@ -1,65 +0,0 @@[m
[31m-package com.ghastconsultancy.ghastconsultancy.model;[m
[31m-[m
[31m-[m
[31m-[m
[31m-import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;[m
[31m-import jakarta.persistence.*;[m
[31m-import lombok.AccessLevel;[m
[31m-import lombok.Getter;[m
[31m-import lombok.NoArgsConstructor;[m
[31m-import lombok.Setter;[m
[31m-[m
[31m-import java.util.ArrayList;[m
[31m-import java.util.List;[m
[31m-[m
[31m-[m
[31m-@Setter[m
[31m-@Getter[m
[31m-@Entity[m
[31m-@NoArgsConstructor[m
[31m-@Table(name ="projetos")[m
[31m-public class Projeto {[m
[31m-[m
[31m-    @Id[m
[31m-    @GeneratedValue(strategy = GenerationType.IDENTITY)[m
[31m-    @Column(name = "id")[m
[31m-    private Long id;[m
[31m-[m
[31m-    @Column(name = "nome", length = 20, nullable = false)[m
[31m-    private String nome;[m
[31m-[m
[31m-    @Column(name = "descricao", length = 100, nullable = false)[m
[31m-    private String descricao;[m
[31m-[m
[31m-    @Enumerated(EnumType.STRING)[m
[31m-    @Column(name = "status", length = 10, nullable = false)[m
[31m-    private StatusProjeto statusProjeto = StatusProjeto.EM_ESPERA;[m
[31m-[m
[31m-    @Setter(AccessLevel.NONE)[m
[31m-    @Column (name = "etapas")[m
[31m-    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true) //[m
[31m-    // garante que não haverá etapas sem projetos[m
[31m-    private List<Etapa> etapas = new ArrayList<>();[m
[31m-[m
[31m-[m
[31m-    public Projeto(String nome, String descricao) {[m
[31m-        this.nome = nome;[m
[31m-        this.descricao = descricao;[m
[31m-    }[m
[31m-[m
[31m-    public void addEtapas(Etapa etapa) {[m
[31m-        if(etapas.size() < 3){[m
[31m-            etapas.add(etapa);[m
[31m-            this.statusProjeto = StatusProjeto.EM_CURSO;[m
[31m-        }[m
[31m-    }[m
[31m-[m
[31m-    public void removerEtapas(Etapa etapa) {[m
[31m-        if (!etapas.isEmpty()) {[m
[31m-            etapas.remove(etapa);[m
[31m-            if (etapas.isEmpty()) {[m
[31m-                this.statusProjeto = StatusProjeto.EM_ESPERA;[m
[31m-            }[m
[31m-        }[m
[31m-    }[m
[31m-}[m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ClienteRepository.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ClienteRepository.java[m
[1mnew file mode 100644[m
[1mindex 0000000..4e6e0b4[m
[1m--- /dev/null[m
[1m+++ b/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ClienteRepository.java[m
[36m@@ -0,0 +1,12 @@[m
[32m+[m[32mpackage com.ghastconsultancy.ghastconsultancy.repository;[m
[32m+[m
[32m+[m[32mimport com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;[m
[32m+[m[32mimport com.ghastconsultancy.ghastconsultancy.model.Cliente;[m
[32m+[m[32mimport org.springframework.data.jpa.repository.JpaRepository;[m
[32m+[m
[32m+[m[32mimport java.util.List;[m
[32m+[m
[32m+[m[32mpublic interface ClienteRepository extends JpaRepository<Cliente, Long> {[m
[32m+[m[32m    // Buscar clientes Vips[m
[32m+[m[32m    List<Cliente> findByTipoCliente(TipoCliente tipoCliente);[m
[32m+[m[32m}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ConsultorRepository.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ConsultorRepository.java[m
[1mindex 076e75d..bd18fe2 100644[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ConsultorRepository.java[m
[1m+++ b/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ConsultorRepository.java[m
[36m@@ -10,6 +10,7 @@[m [mimport java.util.Optional;[m
 [m
 @Repository[m
 public interface ConsultorRepository extends JpaRepository<Consultor, Long> {[m
[32m+[m
     List<Consultor> findByEspecializacao(Integer especializacao);[m
     Optional<Consultor> findByCpf(String cpf);[m
 }[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/EtapaRepository.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/EtapaRepository.java[m
[1mdeleted file mode 100644[m
[1mindex 79c861b..0000000[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/EtapaRepository.java[m
[1m+++ /dev/null[m
[36m@@ -1,13 +0,0 @@[m
[31m-package com.ghastconsultancy.ghastconsultancy.repository;[m
[31m-[m
[31m-import com.ghastconsultancy.ghastconsultancy.enums.StatusEtapa;[m
[31m-import com.ghastconsultancy.ghastconsultancy.model.Etapa;[m
[31m-import org.springframework.data.jpa.repository.JpaRepository;[m
[31m-import org.springframework.stereotype.Repository;[m
[31m-[m
[31m-import java.util.List;[m
[31m-[m
[31m-@Repository[m
[31m-public interface EtapaRepository extends JpaRepository<Etapa, Long> {[m
[31m-    List<Etapa> findByStatusEtapa(StatusEtapa statusEtapa);[m
[31m-}[m
[1mdiff --git a/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ProjetoRepository.java b/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ProjetoRepository.java[m
[1mdeleted file mode 100644[m
[1mindex 24d5b7d..0000000[m
[1m--- a/src/main/java/com/ghastconsultancy/ghastconsultancy/repository/ProjetoRepository.java[m
[1m+++ /dev/null[m
[36m@@ -1,15 +0,0 @@[m
[31m-package com.ghastconsultancy.ghastconsultancy.repository;[m
[31m-[m
[31m-[m
[31m-import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;[m
[31m-import com.ghastconsultancy.ghastconsultancy.model.Projeto;[m
[31m-import org.springframework.data.jpa.repository.JpaRepository;[m
[31m-import org.springframework.stereotype.Repository;[m
[31m-[m
[31m-import java.util.List;[m
[31m-[m
[31m-[m
[31m-@Repository[m
[31m-public interface ProjetoRepository extends JpaRepository<Projeto, Long> {[m
[31m-    List<Projeto> findByStatusProjeto(StatusProjeto status);[m
[31m-}[m
