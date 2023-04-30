class Player(){
    var gesture:String? = null
    var totalWin = 0
    fun setInput(str: String?){
        gesture=str
    }
    fun showPlayerWin(){
        println(totalWin)
    }
}
fun showWin(player1: Player,player2: Player){
    print("Score Player1 = ")
    player1.showPlayerWin()
    print("Score Player2 = ")
    player2.showPlayerWin()
}
fun compareGest(player1: Player,player2: Player){
    val choice = arrayOf<String>("Gunting","Batu","Kertas")
    if(player1.gesture == player2.gesture){
        println("Seri")
    }else{
        for (i in 0..2){
            var j = i+1
            if (j>2){
                j=0
            }
            when(player1.gesture) {
                choice[i] ->
                    if (player2.gesture == choice[j]) {
                        println("Result : Player 2 Menang")
                        addScore(player2)
                    } else {
                        println("Result : Player 1 Menang")
                        addScore(player1)
                    }
            }
        }
    }
}
fun addScore(player: Player){
    player.totalWin+=1
}
fun main(){
    val player1= Player()
    val player2= Player()
    var n:String?="1"

    while (true){
        when(n){
            "1" -> {
                print("Player 1 : ")
                player1.setInput(readLine())
                print("Player 2 : ")
                player2.setInput(readLine())
                compareGest(player1,player2)
            }
            "2" -> showWin(player1,player2)
            "3" -> break
        }
        println("Untuk Main Lagi Masukan \"1\" \n" +
                "Tampilkan Score Masukan \"2\" \n" +
                "Untuk Berhenti Masukan \"3\" ")
        n = readLine()
    }
}