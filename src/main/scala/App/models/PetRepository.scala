package App.models

import scala.collection.mutable.ArrayBuffer



 trait Pet {
    val name : String
    def speak : String
  }

  case class Cat(name : String) extends Pet {

    override def speak: String = "miaow"
  }


  case class Dog(name : String) extends Pet {

    override def speak: String = "woof"
  }


class PetRepository {

  val Pets: ArrayBuffer[Pet] = new ArrayBuffer[Pet]

  def all(): List[Pet] = Pets.toList

  def findByName(name: String): Option[Pet] = Pets.map {
    case matches if matches.name == name => matches
  }.headOption


  def dogs(): List[Pet] = Pets.filter(_.isInstanceOf[Dog]).toList

  def Dogs(): List[Dog] = {
    Pets.toList.flatMap {
      case d@Dog(_) => Some(d)
      case _ => None
    }
  }

  def cats(): List[Pet] = Pets.filter(_.isInstanceOf[Cat]).toList

  def other(): List[Pet] = Pets.filterNot(pet => pet.isInstanceOf[Dog] || pet.isInstanceOf[Cat]).toList

  def add(pet: Pet*): List[Pet] = Pets.++=(pet).toList

  def removeByName(name: String): List[Pet] = {
    this.findByName(name).map { pet =>
      val indexOfPetToRemove = Pets.indexOf(pet)
      this.Pets.remove(indexOfPetToRemove)
    }
    all
  }

  def Other(): List[Pet] = Pets.toList.flatMap {
    //case otherPet if otherPet != isInstanceOf[Cat] || isInstanceOf[Dog] => otherPet
    case d@Dog(_) => None
    case c@Cat(_) => None
    case e => Some(e)

  }
}