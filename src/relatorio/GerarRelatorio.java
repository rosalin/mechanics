/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package relatorio;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rodrigo
 */public class GerarRelatorio {
    public static void gerarRelatorio(JRDataSource source) throws JRException {
		Map map = new HashMap();
		JasperFillManager.fillReportToFile("/home/rodrigo/NetBeansProjects/mechanics/src/relatorio/ServiceReport.jasper", map, source);
		JasperViewer.viewReport("/home/rodrigo/NetBeansProjects/mechanics/src/relatorio/ServiceReport.jrprint", false);
	}
}
