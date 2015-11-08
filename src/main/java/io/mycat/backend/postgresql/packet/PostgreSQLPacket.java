package io.mycat.backend.postgresql.packet;

import java.nio.charset.Charset;

public abstract class PostgreSQLPacket {

	public final static Charset   UTF8 =  Charset.forName("utf-8");
	
	/***
	 * 获取包长度
	 * 
	 * @return
	 */
	public abstract int getLength();

	/***
	 * 获取包标记
	 * 
	 * @return
	 */
	public abstract char getMarker();

	public static enum PacketMarker {
		/**
		 * 认证包
		 */
		B_Auth('R'),

		/***
		 * 密码请求包
		 */
		F_PwdMess('p'),

		/**
		 * 错误包响应
		 */
		B_Error('E'),

		/***
		 * 后台传回的秘钥
		 */
		B_BackendKey('K'),

		/***
		 * paramter 状态信息
		 */
		B_ParameterStatus('S'),

		/**
		 * 等待查询
		 */
		B_ReadyForQuery('Z'),

		/**
		 * 警告响应
		 */
		B_NoticeResponse('N'),
		
		/***
		 * 简单查询
		 */
		F_Query('Q');

		private char value;

		private PacketMarker(char marker) {
			this.value = marker;
		}

		public char getValue() {
			return value;
		}
	}

}
