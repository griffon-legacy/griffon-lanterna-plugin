/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.griffon.runtime.lanterna;

import griffon.core.GriffonController;
import griffon.core.UIThreadManager;
import griffon.core.controller.GriffonControllerActionManager;
import griffon.lanterna.widgets.MutableAction;
import griffon.util.RunnableWithArgs;
import org.codehaus.griffon.runtime.core.controller.AbstractGriffonControllerAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author Andres Almiray
 */
public class LanternaGriffonControllerAction extends AbstractGriffonControllerAction {
    private final MutableAction toolkitAction;

    public LanternaGriffonControllerAction(final GriffonControllerActionManager actionManager, final GriffonController controller, final String actionName) {
        super(actionManager, controller, actionName);
        final LanternaGriffonControllerAction self = this;
        toolkitAction = new MutableAction(new RunnableWithArgs() {
            public void run(Object[] args) {
                actionManager.invokeAction(self.getController(), actionName, args);
            }
        });
        addPropertyChangeListener(KEY_NAME, new PropertyChangeListener() {
            public void propertyChange(final PropertyChangeEvent evt) {
                UIThreadManager.getInstance().executeAsync(new Runnable() {
                    public void run() {
                        toolkitAction.setName(evt.getNewValue().toString());
                    }
                });
            }
        });
    }

    protected void doInitialize() {
        toolkitAction.setName(getName());
    }

    public Object getToolkitAction() {
        return toolkitAction;
    }

    protected void doExecute(Object... args) {
        toolkitAction.doAction();
    }
}
