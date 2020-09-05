/*
 * MIT License
 *
 * Copyright (c) 2020 mdashlw
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ru.mdashlw.smartreply.util;

import java.lang.reflect.Field;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;

public final class ReflectionUtils {

  public static final Field GUI_CHAT_INPUT_FIELD;

  static {
    try {
      GUI_CHAT_INPUT_FIELD = GuiChat.class.getDeclaredField("field_146415_a");
      GUI_CHAT_INPUT_FIELD.setAccessible(true);
    } catch (final NoSuchFieldException exception) {
      throw new RuntimeException(exception);
    }
  }

  private ReflectionUtils() {
  }

  public static GuiTextField getInputField(final GuiChat instance) {
    try {
      return (GuiTextField) GUI_CHAT_INPUT_FIELD.get(instance);
    } catch (final IllegalAccessException exception) {
      throw new RuntimeException(exception);
    }
  }
}
