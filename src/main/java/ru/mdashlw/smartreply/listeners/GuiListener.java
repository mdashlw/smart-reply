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

package ru.mdashlw.smartreply.listeners;

import java.util.Locale;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiPageButtonList.GuiResponder;
import net.minecraft.client.gui.GuiTextField;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.mdashlw.smartreply.SmartReply;
import ru.mdashlw.smartreply.util.ReflectionUtils;

public final class GuiListener {

  @SubscribeEvent
  public void onInitGui(final GuiScreenEvent.InitGuiEvent.Post event) {
    if (event.gui instanceof GuiChat) {
      final GuiTextField field = ReflectionUtils.getInputField((GuiChat) event.gui);

      field.func_175207_a(new GuiChatModifier(field));
    }
  }

  private static class GuiChatModifier implements GuiResponder {

    private final GuiTextField field;

    public GuiChatModifier(final GuiTextField field) {
      this.field = field;
    }

    @Override
    public void func_175321_a(final int p_175321_1_, final boolean p_175321_2_) {
    }

    @Override
    public void onTick(final int id, final float value) {
    }

    @Override
    public void func_175319_a(final int id, final String text) {
      final String lowerText = text.toLowerCase(Locale.ENGLISH);

      if (lowerText.startsWith("/r ") || lowerText.startsWith("/к ")) {
        final String lastSender = SmartReply.INSTANCE.getLastSender();

        if (lastSender != null) {
          this.field.setText("/w " + lastSender + this.field.getText().substring(2));
        }
      }
    }
  }
}
