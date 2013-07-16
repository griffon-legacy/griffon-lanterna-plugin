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

package griffon.lanterna;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.GUIScreen;
import org.codehaus.griffon.runtime.util.AbstractUIThreadHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Executes code honoring Lanterna's threading model.
 *
 * @author Andres Almiray
 */
public class LanternaUIThreadHandler extends AbstractUIThreadHandler {
    private static final Logger LOG = LoggerFactory.getLogger(griffon.lanterna.LanternaUIThreadHandler.class);
    private final GUIScreen screen;

    public LanternaUIThreadHandler(GUIScreen screen) {
        this.screen = screen;
    }

    public boolean isUIThread() {
        boolean isUIThread = screen.isInEventThread();
        if (LOG.isTraceEnabled()) {
            LOG.trace("isUIThread? " + isUIThread);
        }
        return isUIThread;
    }

    public void executeAsync(Runnable runnable) {
        executeSync(runnable);
    }

    public void executeSync(final Runnable runnable) {
        if (isUIThread()) {
            runnable.run();
        } else {
            screen.runInEventThread(new Action() {
                public void doAction() {
                    runnable.run();
                }
            });
        }
    }
}
