fun getList(): List<Int> {
    return arrayListOf(1, 5, 2).sortedDescending()
}

fun List<Int>.sortedDescending() : List<Int> = this.sorted().asReversed()