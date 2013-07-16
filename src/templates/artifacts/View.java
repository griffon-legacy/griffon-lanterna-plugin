@artifact.package@import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import java.util.Map;

import groovy.util.FactoryBuilderSupport;

import griffon.lanterna.LanternaGriffonApplication;
import org.codehaus.griffon.runtime.core.AbstractGriffonView;

public class @artifact.name@ extends AbstractGriffonView {
    // these will be injected by Griffon
    private @artifact.name.plain@Controller controller;
    private @artifact.name.plain@Model model;
    private FactoryBuilderSupport builder;

    public void setController(@artifact.name.plain@Controller controller) {
        this.controller = controller;
    }

    public void setModel(@artifact.name.plain@Model model) {
        this.model = model;
    }

    public void setBuilder(FactoryBuilderSupport builder) {
        this.builder = builder;
    }

    // build the UI
    private Component init() {
        Panel panel = new Panel(Panel.Orientation.VERTICAL);
        panel.addComponent(new Label("Content goes here"));
        return panel;
    }

    @Override
    public void mvcGroupInit(final Map<String, Object> args) {
        execInsideUISync(new Runnable() {
            public void run() {
                Window window = new Window("@artifact.name.plain@");
                window.addComponent(init());
                ((LanternaGriffonApplication) getApp()).getWindowManager().attach("mainWindow", window);
            }
        });
    }
}