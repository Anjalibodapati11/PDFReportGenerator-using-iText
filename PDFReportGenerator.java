import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class PDFReportGenerator {
    public static void main(String[] args) {
        try {
            // Create a new PDF document
            Document document = new Document();

            // Create a writer to save PDF as "Report.pdf"
            PdfWriter.getInstance(document, new FileOutputStream("Report.pdf"));

            // Open the document to add content
            document.open();

            // Add Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("PDF Report Generator", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Add subtitle
            Font subFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph sub = new Paragraph("Created using Java and iText.", subFont);
            sub.setAlignment(Element.ALIGN_CENTER);
            document.add(sub);

            document.add(new Paragraph(" ")); // line break

            // Add Table
            PdfPTable table = new PdfPTable(3); // 3 columns

            table.addCell("Name");
            table.addCell("Subject");
            table.addCell("Marks");

            table.addCell("Anjali");
            table.addCell("Math");
            table.addCell("95");

            table.addCell("Rahul");
            table.addCell("Science");
            table.addCell("89");

            table.addCell("Neha");
            table.addCell("English");
            table.addCell("92");

            document.add(table);

            // Add footer
            document.add(new Paragraph("\nGenerated on: " + new java.util.Date()));

            // Close the document
            document.close();

            System.out.println("✅ PDF created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
