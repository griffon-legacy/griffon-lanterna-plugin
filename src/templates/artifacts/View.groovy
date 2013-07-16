@artifact.package@import com.googlecode.lanterna.gui.*
import org.codehaus.griffon.runtime.core.AbstractGriffonView

class @artifact.name@ extends AbstractGriffonView {
    @artifact.name.plain@Controller controller
    @artifact.name.plain@Model model
    FactoryBuilderSupport builder

    void mvcGroupInit(final Map<String, Object> args) {
        execInsideUISync {
            Window window = new Window("@artifact.name.plain@")
            window.addComponent(init())
            app.windowManager.attach('mainWindow', window)
        }
    }

    private Component init() {
        builder.vbox {
            label('Content goes here')
        }
    }
}