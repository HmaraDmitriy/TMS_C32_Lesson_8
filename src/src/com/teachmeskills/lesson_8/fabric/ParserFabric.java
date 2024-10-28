package com.teachmeskills.lesson_8.fabric;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.document_parser.impl.DocxDocumentParser;
import com.teachmeskills.lesson_8.document_parser.impl.PdfDocumentParser;
import com.teachmeskills.lesson_8.document_parser.impl.TxtDocumentParser;

public class ParserFabric {

   static public IParser createParser(String fileName) {
       if (fileName.endsWith(".docx")) {
           // TODO избавиться от return null и сделать возврат docx парсера +
           return new DocxDocumentParser();
       } else if (fileName.endsWith(".pdf")) {
           return new PdfDocumentParser();
       } else if (fileName.endsWith(".Txt")) {
           return new TxtDocumentParser();
       } else {
           System.out.println("Unknown format");
        return null;
       }
       // TODO (опционально) * попробовать переписать на конструкцию switch-case, может это будет более ёмкая запись +

        /*public IParser createParser(String fileName) {
            switch (fileName.substring(fileName.lastIndexOf('.'))) {
                case ".docx":
                    return new DocxDocumentParser();
                case ".pdf":
                    return new PdfDocumentParser();
                default:
                    return new TxtDocumentParser();
            }
        }*/
   }
}
