/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class LanternaGriffonPlugin {
    String version = '0.1.0'
    String griffonVersion = '1.4.0 > *'
    Map dependsOn = [:]
    List pluginIncludes = []
    String license = 'Apache Software License 2.0'
    List toolkits = ['lanterna']
    List platforms = []
    String documentation = ''
    String source = 'https://github.com/griffon/griffon-lanterna-plugin'

    List authors = [
        [
            id: 'aalmiray',
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Enables Lanterna support'
    String description = '''
Enables [Lanterna][1] as UI toolkit.

Lanterna is a Java library allowing you to write easy semi-graphical user interfaces
in a text-only environment, very similar to the C library curses but with more
functionality. Lanterna supports xterm compatible terminals and terminal emulators
such as konsole, gnome-terminal, putty, xterm and many more. One of the main benefits
of lanterna is that it's not dependent on any native library but runs 100% in pure Java.

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Name*           | *Type*                                                |
| ---------------- | ----------------------------------------------------- |
| action           | `griffon.lanterna.widgets.MutableAction`              |
| actionListBox    | `com.googlecode.lanterna.gui.component.ActionListBox` |
| actions          | `java.util.List`                                      |
| application      | `com.googlecode.lanterna.gui.Window`                  |
| bean             | `java.lang.Object`                                    |
| borderLayout     | `com.googlecode.lanterna.gui.layout.BorderLayout`     |
| button           | `griffon.lanterna.widgets.MutableButton`              |
| checkBox         | `com.googlecode.lanterna.gui.component.CheckBox`      |
| container        | `com.googlecode.lanterna.gui.Component`               |
| emptySpace       | `com.googlecode.lanterna.gui.component.EmptySpace`    |
| hbox             | `com.googlecode.lanterna.gui.component.Panel`         |
| horisontalLayout | `com.googlecode.lanterna.gui.layout.HorisontalLayout` |
| horizontalLayout | `com.googlecode.lanterna.gui.layout.HorisontalLayout` |
| label            | `com.googlecode.lanterna.gui.component.Label`         |
| list             | `java.util.List`                                      |
| panel            | `com.googlecode.lanterna.gui.component.Panel`         |
| passwordBox      | `com.googlecode.lanterna.gui.component.PasswordBox`   |
| progressBar      | `com.googlecode.lanterna.gui.component.ProgressBar`   |
| table            | `com.googlecode.lanterna.gui.component.Table`         |
| textArea         | `com.googlecode.lanterna.gui.component.TextArea`      |
| textBox          | `com.googlecode.lanterna.gui.component.TextBox`       |
| vbox             | `com.googlecode.lanterna.gui.component.Panel`         |
| verticalLayout   | `com.googlecode.lanterna.gui.layout.VerticalLayout`   |
| widget           | `com.googlecode.lanterna.gui.Component`               |

The following packages are automatically imported in Views

 * com.googlecode.lanterna.gui
 * com.googlecode.lanterna.gui.component
 * com.googlecode.lanterna.gui.dialog
 * com.googlecode.lanterna.gui.layout
 * com.googlecode.lanterna.gui.listener
 * com.googlecode.lanterna.input

Configuration
-------------

This plugin provides custom `WindowManager` and `GriffonControllerActionManager`
implementations.


[1]: http://code.google.com/p/lanterna/
'''
}
