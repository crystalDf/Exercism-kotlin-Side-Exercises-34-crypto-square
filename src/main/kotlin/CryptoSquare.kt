import kotlin.math.roundToInt
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {

        val normalized = plaintext.filter { it.isLetterOrDigit() }.toLowerCase()

        if (normalized.isBlank()) return ""

        val rows = sqrt(normalized.length.toDouble()).roundToInt()
        val columns = rows + (if (rows * rows < normalized.length) 1 else 0)

        val matrix = normalized.padEnd(rows * columns, ' ').windowed(columns, columns)

        return (0 until columns).joinToString(" ") { x ->
            (0 until rows).joinToString("") { y -> "${matrix[y][x]}" }
        }
    }

}
