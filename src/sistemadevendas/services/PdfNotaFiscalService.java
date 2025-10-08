package sistemadevendas.services;

import sistemadevendas.model.NotaFiscal;
import sistemadevendas.model.ItemNotaFiscal;
import sistemadevendas.model.Produto;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.PageSize;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Nicolas Ap
 */

public class PdfNotaFiscalService {

    public void gerarPdf(NotaFiscal nota, List<ItemNotaFiscal> itens) throws Exception {
        String arquivo = "nota_" + nota.getIdNotaFiscal() + ".pdf";

        Document doc = new Document(PageSize.A6);
        PdfWriter.getInstance(doc, new FileOutputStream(arquivo));
        doc.open();

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Paragraph header = new Paragraph("NOTA FISCAL\n\n");
        header.setAlignment(Element.ALIGN_CENTER);
        doc.add(header);

        doc.add(new Paragraph("Cliente: " + nota.getCliente().getNomeCliente()));
        doc.add(new Paragraph("Data: " + data.format(nota.getDataEmissao())));
        doc.add(new Paragraph("-----------------------------------------"));

        double total = 0;

        for (ItemNotaFiscal item : itens) {
            Produto p = item.getProduto();
            double precoUnitario = p.getPrecoVenda();
            double subtotal = item.getQuantidade() * precoUnitario;
            total += subtotal;

            doc.add(new Paragraph(
                p.getNomeProduto() + " x" + item.getQuantidade() +
                " - R$ " + String.format("%.2f", subtotal)
            ));
        }

        doc.add(new Paragraph("-----------------------------------------"));
        doc.add(new Paragraph("Total: R$ " + String.format("%.2f", total)));

        doc.close();

    }
}
