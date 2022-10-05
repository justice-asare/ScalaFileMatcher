import java.io.File
import scala.annotation.tailrec

object FileMatcher {

  private def filesHere: Array[File] = (new File(".")).listFiles()

  def filesEnding(query: String): Array[File] = {
    @tailrec
    def fileNamesToList(query: String, listOfFiles: Array[File], remainingFiles: Array[File]): Array[File] = {
      if(remainingFiles.isEmpty) listOfFiles
      else if(remainingFiles.head.toString.endsWith(query)) fileNamesToList(query, listOfFiles :+ remainingFiles.head, remainingFiles.tail)
      else fileNamesToList(query, listOfFiles, remainingFiles.tail)
    }
    fileNamesToList(query, Array.empty, filesHere)
  }

  def filesContaining(query: String): Array[File] = {
    @tailrec
    def fileNamesToList(query: String, listOfFiles: Array[File], remainingFiles: Array[File]): Array[File] = {
      if(remainingFiles.isEmpty) listOfFiles
      else if(remainingFiles.head.toString.contains(query)) fileNamesToList(query, listOfFiles :+ remainingFiles.head, remainingFiles.tail)
      else fileNamesToList(query, listOfFiles, remainingFiles.tail)
    }
    fileNamesToList(query, Array.empty, filesHere)
  }

  def filesRegex(query: String): Array[File] = {
    @tailrec
    def fileNamesToList(query: String, listOfFiles: Array[File], remainingFiles: Array[File]): Array[File] = {
      if(remainingFiles.isEmpty) listOfFiles
      else if(remainingFiles.head.toString.matches(query)) fileNamesToList(query, listOfFiles :+ remainingFiles.head, remainingFiles.tail)
      else fileNamesToList(query, listOfFiles, remainingFiles.tail)
    }
    fileNamesToList(query, Array.empty, filesHere)
  }


  def fileMatching(query: String) (f: (String, String) => Boolean): Array[File] = {
    def fileNamesToList(query: String, listOfFiles: Array[File], remainingFiles: Array[File]): Array[File] = {
      if(remainingFiles.isEmpty) listOfFiles
      else if(f(query, remainingFiles.head.toString)) fileNamesToList(query, listOfFiles :+ remainingFiles.head, remainingFiles.tail)
      else fileNamesToList(query, listOfFiles, remainingFiles.tail)
    }
    fileNamesToList(query, Array.empty, filesHere)
  }

  def naiveFilesEnding(query: String): Array[File] = for (file <- filesHere if file.getName.endsWith(query)) yield file

  def endsWith(key: String) : Array[File] = fileMatching(key) ((query: String, filename: String) => filename.endsWith(query))

  def filesComplexLookup(query: String): Array[File] = fileMatching(query) {
    (fileName, queryString) => {
      fileName.length < 5 &&
        fileName.equalsIgnoreCase(queryString) &&
        queryString.charAt(1) == 's'
    }
  }

  //Togo Code
  def filesMatching(func: (String, String) => Boolean): Function[String,Array[File]] = {
    @tailrec
    def filesMatchingAcc(query: String)(fileArray: Array[File], accFileArray: Array[File]): Array[File] = {
      if(fileArray.isEmpty) accFileArray
      else filesMatchingAcc(query)(fileArray.tail,
        if(func(fileArray.head.getAbsolutePath, query)) accFileArray :+ fileArray.head
        else accFileArray
      )
    }
    (query: String) => filesMatchingAcc(query)(filesHere, Array())
  }


  //    def filesEnding(query:String): Array[File] = fileMatching(query: String)(_ endsWith _)


  def main(args: Array[String]): Unit = {
    //    filesEnding("ea") foreach println
    //    filesContaining("b") foreach println
    //    filesRegex("(.*)(.*)") foreach println
    //    fileMatching("ea", (query: String, filename: String) => filename.endsWith(query)) foreach println
    //    fileMatching("(.*)(.*)", (query: String, filename: String) => filename.matches(query)) foreach println
    //    fileMatching("b", (query: String, filename: String) => filename.contains(query)) foreach println
    //    endsWith("ea") foreach println


    def endWithMatching: String => Array[File] = filesMatching(_ endsWith _)
    val startWithMatching = filesMatching(_ startsWith _)
    val containsMatching = filesMatching(_ contains _)
    val regexMatching = filesMatching(_ matches _)
    endWithMatching("") foreach println
    //    startWithMatching("") foreach println
    //    containsMatching("") foreach println
    //    regexMatching("")

  }

}
