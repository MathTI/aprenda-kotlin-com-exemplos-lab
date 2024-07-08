enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

class Usuario(val nome: String, val cpf: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
        println()
    }
    
    fun listarInscritos() {
        println("Usuários matriculados na formação $nome:")
        for ((indice, usuario) in inscritos.withIndex()) {
        	println("${indice + 1}: ${usuario.nome}")
            
        }
    }
}

fun main() {
    
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Web Avançado", 150, Nivel.AVANCADO)
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2, conteudo3))
    
    val usuario1 = Usuario("Alice", "111")
    val usuario2 = Usuario("Bob", "222")
    
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    
    formacaoKotlin.listarInscritos()
}
