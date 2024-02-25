object CoffeeBreak {
    def listWithElementsMoreThan(list: List[Int]): Int => List[Int] = {
        numberMoreThan => list.filter(element => element > numberMoreThan)
    }
}

object Driver extends App {
    val list: List[Int] = List(1, 2, 3, 4, 6, 8);

    val listWithElementsMoreThan: Int => List[Int] = CoffeeBreak.listWithElementsMoreThan(list);

    assert(listWithElementsMoreThan(3) == List(4, 6, 8));
}