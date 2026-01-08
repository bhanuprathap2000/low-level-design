package miscellaneous;

public class DocumentProcessor {

    public static void main(String[] args) {


        Document editableDocument = new EditableDocument();

        Document readOnlyDocument = new ReadOnlyDocument();

        processDocumentAndSave(readOnlyDocument,editableDocument);


    }


    private static void processDocumentAndSave(Document editableDocument, Document readOnlyDocument){

        System.out.println(editableDocument.getData());


//        editableDocument.save("Editable new data..........");


        System.out.println(editableDocument.getData());
    }
}
