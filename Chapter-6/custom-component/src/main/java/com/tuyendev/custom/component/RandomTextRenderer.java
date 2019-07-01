package com.tuyendev.custom.component;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = RandomTextComponent.COMPONENT_FAMILY, rendererType = RandomTextRenderer.RENDERER_TYPE)
public class RandomTextRenderer extends Renderer {

    /** Renderer type of {@link RandomTextRenderer}. */
    public static final String RENDERER_TYPE = "com.apress.projsf2html5.components.RandomTextRenderer";

    private static final Logger LOG = Logger.getLogger(RandomTextRenderer.class.getName());

    @Override
    public void encodeEnd(FacesContext context, UIComponent uicomponent) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        RandomTextComponent component = (RandomTextComponent) uicomponent;
        try {
            writer.startElement("div", component);
            writer.writeAttribute("id", component.getClientId(), "id");

            try {
                writer.write(component.getRandomText());
            } catch (IOException randomTextException) {
                writer.write(randomTextException.getMessage());
                LOG.log(Level.SEVERE, "Could not generate random text", randomTextException);
            }

            writer.endElement("div");
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Could not generate markup", ex);
        }
    }
}