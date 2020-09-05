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

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.mdashlw.smartreply.SmartReply;

public final class ChatListener {

  public static final Pattern DM_FROM_PATTERN = Pattern.compile("From (?:\\[[\\w\\s+]+] )?(\\w+):");

  @SubscribeEvent
  public void onChatMessageReceived(final ClientChatReceivedEvent event) {
    if (event.type != (byte) 0) {
      return;
    }

    final String text = event.message.getUnformattedText();

    if (!text.startsWith("From ")) {
      return;
    }

    final Matcher matcher = ChatListener.DM_FROM_PATTERN.matcher(text);

    if (!matcher.find()) {
      return;
    }

    final String name = matcher.group(1);

    SmartReply.INSTANCE.setLastSender(name);
  }
}
